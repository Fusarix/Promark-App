package derek.promarkapp;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

/**
 * Created by Derek-PC.
 */
@Dao
public interface DealerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Dealer... dealers);
}
