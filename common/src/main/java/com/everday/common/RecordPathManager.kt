package com.everday.common

object  RecordPathManager {
    val maps = HashMap<String,ArrayList<PathBean>>()

    fun addGroupInfo(groupName:String,pathName:String,clz:Any){
        val arrayList = maps[groupName]
        if(arrayList.isNullOrEmpty()){
            val list = ArrayList<PathBean>()
            list.add(PathBean(pathName,clz))
            maps[groupName] = list
        }else{

        }
    }

    fun startTargetActivity(groupName: String,pathName: String):Any?{
        val arrayList = maps[groupName]
        arrayList?.forEach{
            if(it.path == pathName){
                return it.clz
            }
        }
        return null
    }
}