package org.yearup.data;


import org.yearup.models.Profile;

public interface ProfileDao
{
    Profile create(Profile profile);
    Profile getByUserId (int profileId);
    Profile update (int userId, Profile profile);
}
