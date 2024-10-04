import java.util.*;
public class DotCom {//переменные экземпляра класса
    private ArrayList<String> locationCells;
    private String name;
    public void setLocationCells (ArrayList<String> loc) {
        locationCells = loc;
    }//сеттер обновляет положение класса
    public void setName(String n){
        name = n;
    }
    public String checkYourself (String userInput){
        String result = "Mimo";
        int index = locationCells.indexOf(userInput);//ежели данные совпали, вернет его местоположения, если нет->
        if (index >= 0) {
            locationCells.remove(index);//-> удаляет элемент
            if (locationCells.isEmpty()) {
                result = "Potopil";
                System.out.println("vi potopili" + name + ":(");
        }else {
                result = "Popal";
        }
        }
        System.out.println(result);
        return result;
    }
}
