package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

public class Main extends Application {

   /* @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }*/
    @Override
    public void start(Stage stage) throws IOException {


        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        String st ;
        List<String> list = new ArrayList<>();
        while ((st=br.readLine())!=null){
           list.add(st);
        }
        HashMap<Integer, Double> map = new HashMap();
        HashMap<Integer, Double> map2 = new HashMap();

        List<String> list1 = Arrays.asList(list.get(0).split(","));
        List<String> list2 = Arrays.asList(list.get(1).split(","));
        List<String> list3 = Arrays.asList(list.get(2).split(","));
        List<String> list4 = Arrays.asList(list.get(3).split(","));

            for(int i=1;i<list2.size();i++){
                map.put(Integer.parseInt(list1.get(i)),Double.parseDouble(list2.get(i)));
                map2.put(Integer.parseInt(list3.get(i)),Double.parseDouble(list4.get(i)));
            }

        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("year");
        yAxis.setLabel("Percentage votes");

        LineChart<Number,Number> lineChart = new LineChart<>(xAxis,yAxis);
        XYChart.Series data = new XYChart.Series();
        XYChart.Series data1 = new XYChart.Series();
        for(Map.Entry<Integer, Double> value :map.entrySet()){
            data.getData().add(new XYChart.Data(value.getKey(),value.getValue()));
        }
        for(Map.Entry<Integer, Double> value1 :map2.entrySet()){
            data1.getData().add(new XYChart.Data(value1.getKey(),value1.getValue()));
        }
        lineChart.getData().add(data);
        lineChart.getData().add(data1);
        Scene view = new Scene(lineChart,640,480);
        stage.setScene(view);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
