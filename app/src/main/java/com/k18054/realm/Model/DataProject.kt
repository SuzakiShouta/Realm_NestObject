package com.k18054.realm.Model

// こういうネストなデータ構造があったとする。
data class DataProject (
    val id: String,
    val name: String,
    val setting: DataSetting
)

data class DataSetting (
    val dayOfWeek: Array<String>,
    val sensors: Array<DataSensor>
    )

data class DataSensor (
    val name: String
    )

//そしてこういう宣言をしたい。
val myProject: DataProject = DataProject(
    "11AA",
    "ImDataProject",
    DataSetting(
        arrayOf("月","火"),
        arrayOf(
            DataSensor("Acc"),
            DataSensor("Gyr")
        )
    )
)




