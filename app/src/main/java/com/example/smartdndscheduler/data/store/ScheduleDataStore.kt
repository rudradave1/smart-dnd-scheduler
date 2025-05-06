package com.example.smartdndscheduler.data.store

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.smartdndscheduler.data.model.DndSchedule
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Extension property to get DataStore instance
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "schedules")

object ScheduleDataStore {
    private val gson = Gson()
    private val SCHEDULES_KEY = stringPreferencesKey("dnd_schedules")

    fun getSchedules(context: Context): Flow<List<DndSchedule>> =
        context.dataStore.data.map { preferences ->
            val json = preferences[SCHEDULES_KEY] ?: "[]"
            gson.fromJson(json, object : TypeToken<List<DndSchedule>>() {}.type)
        }

    suspend fun saveSchedules(context: Context, schedules: List<DndSchedule>) {
        val json = gson.toJson(schedules)
        context.dataStore.edit { preferences ->
            preferences[SCHEDULES_KEY] = json
        }
    }
}