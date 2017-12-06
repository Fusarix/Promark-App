package derek.promarkapp;

import android.arch.persistence.room.Room;
import android.content.Context;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Derek-PC.
 */
@Database(entities = {Film.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FilmDao filmDao();
}
