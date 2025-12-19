package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.data.ShoppingCartDao;
import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;
import org.yearup.models.Product;

import javax.sql.DataSource;
import java.sql.*;

@Component
public class MySqlShoppingCartDao extends MySqlDaoBase implements ShoppingCartDao {

    public MySqlShoppingCartDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public ShoppingCart getByUserId(int userId) {
        ShoppingCart cart = new ShoppingCart();
        String sql = "SELECT sc.user_id, sc.product_id, sc.quantity, " +
                "p.product_id, p.name, p.price, p.category_id, p.description, " +
                "p.subcategory, p.stock, p.featured, p.image_url " +
                "FROM shopping_cart sc " +
                "JOIN products p ON sc.product_id = p.product_id " +
                "WHERE sc.user_id = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, userId);

            try (ResultSet row = statement.executeQuery()) {
                while (row.next()) {
                    ShoppingCartItem item = new ShoppingCartItem();

                    // Map the product
                    Product product = MySqlProductDao.mapRow(row);
                    item.setProduct(product);

                    // Set the quantity from shopping cart
                    item.setQuantity(row.getInt("quantity"));

                    // Add item to cart
                    cart.add(item);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return cart;
    }

    @Override
    public boolean containsProduct(int userId, int productId)
    {
        String query = """
            SELECT COUNT(*)
            FROM shopping_cart
            WHERE user_id = ? AND product_id = ?
            """;

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query))
        {
            statement.setInt(1, userId);
            statement.setInt(2, productId);

            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getInt(1) > 0;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void addProductToCart(int userId, int productId) {
        String sql = "INSERT INTO shopping_cart (user_id, product_id, quantity) " +
                "VALUES (?, ?, 1) " +
                "ON DUPLICATE KEY UPDATE quantity = quantity + 1";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, userId);
            statement.setInt(2, productId);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateShoppingCart(int userId, int productId, int quantity) {
        String sql = "UPDATE shopping_cart SET quantity = ? WHERE user_id = ? AND product_id = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, quantity);
            statement.setInt(2, userId);
            statement.setInt(3, productId);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteCart(int userId) {
        String sql = "DELETE FROM shopping_cart WHERE user_id = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, userId);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
