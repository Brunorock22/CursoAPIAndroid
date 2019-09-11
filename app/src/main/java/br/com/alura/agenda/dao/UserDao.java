package br.com.alura.agenda.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.alura.agenda.model.Aluno;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<Aluno> getAll();

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<Aluno> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    Aluno findByName(String first, String last);

    @Insert
    void insertAll(Aluno... users);

    @Delete
    void delete(Aluno user);
}
