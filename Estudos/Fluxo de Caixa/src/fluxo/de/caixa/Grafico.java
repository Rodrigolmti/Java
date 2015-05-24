package fluxo.de.caixa;

import java.text.SimpleDateFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.Range;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;

/**
 *
 * @author Rodrigo Lopes Martins
 * Esta classe e responsavel por criar o grafico com os parametros
 * requeridos pelo construtor Grafico da classe
 */
public class Grafico {
    
 private TimeSeriesCollection dataset;
    
    public Grafico(int dia1,int mes1,int ano1,int dia2,int mes2,int ano2,
            double valor1, double valor2){
        dataset = new TimeSeriesCollection();
        TimeSeries data = new TimeSeries("Valor informado");
        int auxData = 1;
        boolean valid = false;
        int diaAux = dia1;
        double valorAux=0;
        double valorAux1 = valor1;
        
        for(int a=0; a < dia1;a++) {//Seta o valor 0 para a data anterior
            data.addOrUpdate(new Day(auxData,mes1,ano1),valorAux);
            auxData++;
        }
        for(int b=diaAux; b < dia2;b++) {//Seta o valor1 do dia1 ao dia2
            data.addOrUpdate(new Day(diaAux,mes1,ano1),valor1);
            diaAux++;
        }
        data.addOrUpdate(new Day(dia2,mes2,ano2),valor2);
         
        dataset.addSeries(data);

        final JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Fluxo de caixa",
                "Dias",
                "Valor",
                dataset,
                true,
                true,
                false);
        
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setAxisOffset(new RectangleInsets(5.0, 10.0, 10.0, 5.0));
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer)plot.getRenderer();
        renderer.setBaseShapesVisible(true);
        renderer.setBaseShapesFilled(true);
        NumberAxis numberAxis = (NumberAxis)plot.getRangeAxis();
        DateAxis axis = (DateAxis)plot.getDomainAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("dd-MM-yyyy"));
        axis.setAutoTickUnitSelection(false);
        axis.setVerticalTickLabels(true);
        ChartFrame frame = new ChartFrame("Aplicação para gerar o fluxo de caixa",chart);
        frame.pack();
        frame.setVisible(true);
        plot.setRenderer(renderer);
    }
}
