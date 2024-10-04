import java.util.*;

public class DotComBust {//объявляем и инициализируем переменные, которые нам понадобятся
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();//создаем коллекцию только для объектов DotCom
    private int numOfGuesses = 0;
    private void setUpGame() {//далее создаем три объекта, даем им "имена" и помещаем в коллекцию
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);
        System.out.println("Vasha cel potopit tri saita");//краткие инструкции для пользователя
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Postaraites potopit za minimalnoe kolichestvo hodov");
        for (DotCom dotComSet : dotComsList){//перебираем циклом и повторяем с каждым объектом в списке
            ArrayList<String> newLocation = helper.placeDotCom(3);//запрашиваем у вспомогательного объекта адрес "сайта"
            dotComSet.setLocationCells(newLocation);//вызываем сеттер из объекта, что-бы передать местоположение которое получили из вспомогательного объекта
        }
    }
    private void startPlaying() {
        while (!dotComsList.isEmpty()) {//до тех пор пока список объектов не станет пустым
            String userGuess = helper.getUserInput("Sdelaite hod");//получаем пользовательский ввод
            checkUserGuess(userGuess);//вызываем метод с полученным от пользователя значением
        }
        finishGame();// вызываем метод для получения итогов
    }
    private void checkUserGuess (String userGuess) {
        numOfGuesses++;//инкрементируем количесвто попыток которые сделал пользователь
        String result = "Mimo";//по умолчанию обозначает промах пока не выявлено обратного
        for (DotCom dotComToTest : dotComsList){//повторяем для всех объектов в списке
            result = dotComToTest.checkYourself(userGuess);//просим проверить ход пользователя
            if (result.equals("Popal")){
                break;
            }
            if (result.equals("Potopil")){
                dotComsList.remove(dotComToTest);//нашли целиком и удаляем из списка сайтов
                break;
            }
        }
        System.out.println(result);//выводим для пользователя результат
    }
    private void finishGame(){//выводим итоговые данные о том как прошла игра
        System.out.println("Vse saiti ushli na dno");
        System.out.println("Eto zanialo u vas" + numOfGuesses + "popitok");
    }
    public static void main(String[] args) {
        DotComBust game = new DotComBust();//создаем игровой объект
        game.setUpGame();//объект подготавливает игру
        game.startPlaying();//начинаем игру
    }
}