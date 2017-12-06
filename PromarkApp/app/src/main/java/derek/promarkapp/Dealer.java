package derek.promarkapp;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Derek-PC on 2017-11-30.
 */
@Entity
public class Dealer {

    public Dealer(int dealerId, String userName, String password) {
        this.dealerId = dealerId;
        this.userName = userName;
        this.password = password;
    }

    public int getDealerId() {
        return dealerId;
    }

    public void setDealerId(int dealerId) {
        this.dealerId = dealerId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @PrimaryKey(autoGenerate = true)
    public int dealerId;
    @ColumnInfo(name = "user_name")
    public String userName;
    @ColumnInfo(name = "password")
    public String password;
}
