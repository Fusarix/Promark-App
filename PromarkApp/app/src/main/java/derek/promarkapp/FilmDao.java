package derek.promarkapp;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Derek-PC.
 */
@Dao
public interface FilmDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Film... films);

    @Query("SELECT film_name FROM Film WHERE filmId = :filmId")
    String getFilmName(int filmId);

    @Query("SELECT tse_transmitted FROM Film WHERE filmId = :filmId")
    int getTseTransmitted(int filmId);

    @Query("SELECT tse_reflected FROM Film WHERE filmId = :filmId")
    int getTseReflected(int filmId);

    @Query("SELECT tse_absorbed FROM Film WHERE filmId = :filmId")
    int getTseAbsorbed(int filmId);

    @Query("SELECT vl_transmitted FROM Film WHERE filmId = :filmId")
    int getVlTransmitted(int filmId);

    @Query("SELECT vl_reflected FROM Film WHERE filmId = :filmId")
    int getVlReflected(int filmId);
}
