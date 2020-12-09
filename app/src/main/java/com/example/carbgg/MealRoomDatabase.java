package com.example.carbgg;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Creates database.
 */

@Database(entities = {Meal.class}, version = 3, exportSchema = false)
public abstract class MealRoomDatabase extends RoomDatabase {
    /**
     * Database creation.
     *
     * @return Returns the database instance.
     */
    public abstract MealDao mealDao();
    private static volatile MealRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static MealRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MealRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MealRoomDatabase.class, "meal_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Creates database if one does not exist and populates it with entries.
     */

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                MealDao dao = INSTANCE.mealDao();
                dao.deleteAll();
                Meal milk_glass = new Meal ("Milk glass", 10, "");
                dao.insert(milk_glass);
                Meal yoghourt = new Meal ("Yoghourt can", 25, "");
                dao.insert(yoghourt);
                Meal bread_regular = new Meal ("Bread", 15, "");
                dao.insert(bread_regular);
                Meal bread_roll_regular = new Meal ("Bread roll", 30, "");
                dao.insert(bread_roll_regular);
                Meal baguette = new Meal ("Baguette 10cm", 30, "");
                dao.insert(baguette);
                Meal cracker = new Meal ("Cracker", 5, "");
                dao.insert(cracker);
                Meal ricecake = new Meal ("Ricecake", 5, "");
                dao.insert(ricecake);
                Meal crisp_bread = new Meal ("Crisp bread", 10, "");
                dao.insert(crisp_bread);
                Meal sour_crisp_bread = new Meal("Sour crisp bread", 5, "");
                dao.insert(sour_crisp_bread);
                Meal karelian_pasty_regular = new Meal ("Karelian pasty regular", 25, "");
                dao.insert(karelian_pasty_regular);
                Meal karelian_pasty_small = new Meal ("Karelian pasty", 10, "");
                dao.insert(karelian_pasty_small);
                Meal porridge_water = new Meal ("Porridge 2dl in water", 20, "");
                dao.insert(porridge_water);
                Meal porridge_milk = new Meal("Porridge 2dl in milk", 30, "");
                dao.insert(porridge_milk);
                Meal cereal = new Meal ("Cereal 3dl", 30, "");
                dao.insert(cereal);
                Meal croissant = new Meal ("Croissant", 20, "");
                dao.insert(croissant);
                Meal banana = new Meal ("Banana", 20, "");
                dao.insert(banana);
                Meal hamburger_regular = new Meal("Hamburger regular", 30, "");
                dao.insert(hamburger_regular);
                Meal hamburger_large = new Meal ("Hamburger large", 40, "");
                dao.insert(hamburger_large);
            });
        }
    };
}