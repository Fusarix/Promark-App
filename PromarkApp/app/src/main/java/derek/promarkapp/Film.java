package derek.promarkapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Derek-PC.
 */

@Entity
public class Film {


    public Film(int filmId, String filmName, int tseTransmitted,
                int tseReflected, int tseAbsorbed, int vlTransmitted, int vlReflected) {
        this.filmId = filmId;
        this.filmName = filmName;
        this.tseTransmitted = tseTransmitted;
        this.tseReflected = tseReflected;
        this.tseAbsorbed = tseAbsorbed;
        this.vlTransmitted = vlTransmitted;
        this.vlReflected = vlReflected;
    }

    @PrimaryKey(autoGenerate = true)
    public int filmId;
    @ColumnInfo(name = "film_name")
    public String filmName;
    @ColumnInfo(name = "tse_transmitted")
    public int tseTransmitted;
    @ColumnInfo(name = "tse_reflected")
    public int tseReflected;
    @ColumnInfo(name = "tse_absorbed")
    public int tseAbsorbed;
    @ColumnInfo(name = "vl_transmitted")
    public int vlTransmitted;
    @ColumnInfo(name = "vl_reflected")
    public int vlReflected;


    public int getFilmId(){
        return filmId;
    }
    public void setFilmId(int filmId){
        this.filmId = filmId;
    }

    public String getFilmName(){
        return filmName;
    }

    public void setFilmName(String filmName){
        this.filmName = filmName;
    }

    public int getTseTransmitted(){
        return tseTransmitted;
    }

    public void setTseTransmitted(int tseTransmitted){
        this.tseTransmitted = tseTransmitted;
    }

    public int getTseReflected(){
        return tseReflected;
    }

    public void setTseReflected(int tseReflected){
        this.tseReflected = tseReflected;
    }

    public int getTseAbsorbed(){
        return tseAbsorbed;
    }

    public void setTseAbsorbed(int tseAbsorbed){
        this.tseAbsorbed = tseAbsorbed;
    }

    public int getVlTransmitted(){
        return vlTransmitted;
    }

    public void setVlTransmitted(int vlTransmitted){
        this.vlTransmitted = vlTransmitted;
    }

    public int getVlReflected(){
        return vlReflected;
    }

    public void setVlReflected(int vlReflected){
        this.vlReflected = vlReflected;
    }


}