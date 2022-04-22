class TestDemo {
    fun stringHelper (S : String) : Int { return 0 }

    fun getScreenName () :String {
        return "splash screen"
    }

    fun generateLayoutName(screenName : String, technology : String) : String {
        screenName.replace("\\s+", " ")
        var layoutName :String = ""
        if(technology.equals("Android")){
            layoutName =  "activity_" + screenName.lowercase().replace(" ", "_")
        }else if(technology.equals("Flutter")){
            layoutName =  screenName.lowercase().replace(" ", "_")
        }else if(technology.equals("iOS")){
            layoutName =  screenName.split(" ")
                .joinToString(separator = "", transform = String::capitalize) + "View"
        }
        return layoutName
    }

    fun generateControllerName(screenName : String, technology : String) : String {
        screenName.replace("\\s+", " ")
        var controllerName :String = ""
        if(technology.equals("Android")){
            controllerName = screenName.split(" ")
                .joinToString(separator = "", transform = String::capitalize) + "Activity"
        }
        return controllerName
    }

    fun generateModelName(screenName : String, technology : String) : String {
        screenName.replace("\\s+", " ")
        var modelName :String = ""
        if(technology.equals("Android")){
            modelName = screenName.split(" ")
                .joinToString(separator = "", transform = String::capitalize) + "Model"
        }else if(technology.equals("Flutter")){

        }
        return modelName
    }
}
