package com.georgewilliam.speedforcre.projectspeedforceldb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

/**
 * Created by georgetamate on 8/5/16.
 */
public class DB_Controller extends SQLiteOpenHelper {
    public DB_Controller(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "LocalSpeedforce.db", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE TB_USUARIO(ID INTEGER PRIMARY KEY AUTOINCREMENT, ID_USUARIO TEXT UNIQUE, NOMBRES TEXT, APELLIDOS TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS TB_USUARIO");
        onCreate(sqLiteDatabase);
    }

    // CRUD methods

    public void insert_usuario(String id_usuario, String nombres, String apellidos) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID_USUARIO", id_usuario);
        contentValues.put("NOMBRES", nombres);
        contentValues.put("APELLIDOS", apellidos);
        this.getWritableDatabase().insertOrThrow("TB_USUARIO", "", contentValues);
    }

    public void delete_usuario(String id_usuario) {
        this.getWritableDatabase().delete("TB_USUARIO", "ID_USUARIO='" + id_usuario + "'", null);
    }

    public void update_usuario(String id_usuario, String nombres, String apellidos) {
        this.getWritableDatabase().execSQL("UPDATE TB_USUARIO SET NOMBRES='"+nombres+"' WHERE ID_USUARIO='"+id_usuario+"'");
        this.getWritableDatabase().execSQL("UPDATE TB_USUARIO SET APELLIDOS='"+apellidos+"' WHERE ID_USUARIO='"+id_usuario+"'");
    }

    public void list_all_usuario(TextView txtv) {
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM TB_USUARIO", null);
        txtv.setText("");
        while(cursor.moveToNext()) {
            txtv.append(cursor.getString(1)+"\n"
                    +cursor.getString(2)+" "+cursor.getString(3)

                    +"\n\n");
        }


        // <TB_USUARIO table rows> //
        // 0. ID
        // 1. ID_USUARIO
        // 2. NOMBRES
        // 3. APELLIDOS
        //
        ////////////////////
        //
        // 4. Email
        // 5. Sexo
        // 6. F.Nac.
        // 7. Ciudad
        // 8. Telefono
        // 9. Altura
        // 10. Peso
        // 11. Estatus
        //
        // Foto
        // Contrasena
    }
}
