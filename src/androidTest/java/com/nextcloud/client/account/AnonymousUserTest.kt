package com.nextcloud.client.account

import android.os.Parcel
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AnonymousUserTest {
    @Test
    fun anonymousUserImplementsParcelable() {
        // GIVEN
        //      anonymous user instance
        val original = AnonymousUser("test_account")

        // WHEN
        //      instance is serialized into Parcel
        //      instance is retrieved from Parcel
        val parcel = Parcel.obtain()
        parcel.setDataPosition(0)
        parcel.writeParcelable(original, 0)
        parcel.setDataPosition(0)
        val retrieved = parcel.readParcelable<User>(User::class.java.classLoader)

        // THEN
        //      retrieved instance in distinct
        //      instances are equal
        Assert.assertNotSame(original, retrieved)
        Assert.assertTrue(retrieved is AnonymousUser)
        Assert.assertEquals(original, retrieved)
    }
}
