package org.yearup.data;

import org.yearup.models.ShoppingCart;

public interface ShoppingCartDao
{
    // add additional method signatures here
    boolean containsProduct(int userId, int productId);

    ShoppingCart getByUserId(int userId);

    void addProductToCart(int userId, int productId);

    void updateShoppingCart(int userId, int productId, int quantity);

    void deleteCart(int userId);
}
