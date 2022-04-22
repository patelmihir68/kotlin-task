class TestDemo {

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
// ==========================================
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test



internal class testDemoTest {

    @Test
    fun layoutName() {
        val testDemo = TestDemo()
        val screenName = testDemo.getScreenName()
        val layoutName = testDemo.generateLayoutName(screenName, "Android");
        val hasNumber = containsNumber(layoutName)
        assertEquals(hasNumber, true, "layout name contain number")
    }

    @Test
    fun controllerName() {
        val testDemo = TestDemo()
        val screenName = testDemo.getScreenName()
        val controllerName = testDemo.generateControllerName(screenName, "Android");
        println(controllerName)
    }

    @Test
    fun modelName() {
        val testDemo = TestDemo()
        val screenName = testDemo.getScreenName()
        val modelName = testDemo.generateModelName(screenName, "Android");
        println(modelName)
    }

    fun containsNumber(s: String?) :Boolean {
        var containsNumber = false
        if (s != null && !s.isEmpty()) {
            for (c in s.toCharArray()) {
                if (Character.isDigit(c).also { containsNumber = it }) {
                    break
                }
            }
        }
        return containsNumber
    }
}
