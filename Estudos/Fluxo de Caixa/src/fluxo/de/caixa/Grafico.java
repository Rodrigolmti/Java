package fluxo.de.caixa;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author rodrigo
 */
public class Grafico {
    
 private XYSeriesCollection dataset;
    
    public Grafico(int data1, int data2,double valor1, double valor2){
        dataset = new XYSeriesCollection();
        XYSeries data = new XYSeries("Valor informado");
        double aux=0;
        int auxData = 0;
        
        for(int a=0; auxData < data1;a++){
            data.add(auxData,aux);
            auxData++;
        }
        for(int i = data1 ; i < data2 ; i++) {
            data.add(data1,valor1);
            data1++;
        
        }
        data.add(data2,valor2);
        dataset.addSeries(data);
        showGraph();
    }
    
    private void showGraph()  {
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500,270));
        final ApplicationFrame frame = new ApplicationFrame("Fluxo de caixa");
        frame.setContentPane(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private JFreeChart createChart(final XYDataset dataset) {
        final JFreeChart chart = ChartFactory.createXYLineChart(
                "Fluxo de caixa",
                "Dias",
                "Valor",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                true);
        
        XYPlot plot = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, true);
        plot.setRenderer(renderer);
        
        return chart;
    }
    
}
