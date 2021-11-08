package com.k18054.realm.Model

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.Ignore
import io.realm.annotations.LinkingObjects
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class RealmProject: RealmObject() {
    @PrimaryKey var id: String = ""
    var name: String = ""
    var setting: RealmSetting? = null
    @Ignore
    var tempReference: Int = 0
}

open class RealmSetting : RealmObject() {
    var name: String? = null
    var sensor: RealmList<RealmSensor> = RealmList()

//    @LinkingObjects("setting")
//    val project: RealmResults<RealmProject>? = null
}

open class RealmSensor : RealmObject() {
    var name: RealmList<String> = RealmList("")

//    @LinkingObjects("sensors")
//    val setting: RealmResults<RealmProject>? = null
}

class Project () {



}