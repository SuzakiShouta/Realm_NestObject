package com.k18054.realm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.k18054.realm.Model.RealmProject
import com.k18054.realm.Model.RealmSensor
import com.k18054.realm.Model.RealmSetting
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmList

class MainActivity : AppCompatActivity() {

    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Realmの初期化
        Realm.init(this)

        // 起動するたびRealmを全部消す。
        // あとMainActivityで処理したからか？UIスレッド処理を許可
        val realmConfig = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .allowWritesOnUiThread(true)
            .build()
        Realm.deleteRealm(realmConfig)
        Realm.setDefaultConfiguration(realmConfig)

        realm = Realm.getDefaultInstance()

        create()
    }

    fun create() {
        realm.executeTransaction { realm ->
            val project = realm.createObject(RealmProject::class.java, "BB22")
            val setting = realm.createObject(RealmSetting::class.java)
            val sensor = realm.createObject(RealmSensor::class.java)
            sensor.name = RealmList("acc", "gyr")
            setting.name = "RealmSetting"
            setting.sensor = RealmList(sensor)
            project.name = "RealmProject"
            project.setting = setting
            project.tempReference = 42

        }
    }

}