/* ============
 * Orson Charts
 * ============
 * 
 * (C)opyright 2013, by Object Refinery Limited.
 * 
 */

package com.orsoncharts.demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.orsoncharts.ChartPanel3D;
import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.data.category.CategoryDataset3D;
import com.orsoncharts.data.category.StandardCategoryDataset3D;
import com.orsoncharts.data.DefaultKeyedValues;
import com.orsoncharts.graphics3d.swing.DisplayPanel3D;
import com.orsoncharts.legend.LegendAnchor;

/**
 * A demo of a 3D line chart.
 */
public class LineChart3DDemo2 extends JFrame {

    /**
     * Creates a new test app.
     *
     * @param title  the frame title.
     */
    public LineChart3DDemo2(String title) {
        super(title);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        getContentPane().add(createDemoPanel());
    }

    /**
     * Returns a panel containing the content for the demo.  This method is
     * used across all the individual demo applications to allow aggregation 
     * into a single "umbrella" demo (OrsonChartsDemo).
     * 
     * @return A panel containing the content for the demo.
     */
    public static JPanel createDemoPanel() {
        DemoPanel content = new DemoPanel(new BorderLayout());
        content.setPreferredSize(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        CategoryDataset3D dataset = createDataset();
        Chart3D chart = Chart3DFactory.createLineChart("Quarterly Profits", 
                "Large Banks in USA", dataset, null, "Quarter", "$ millions");
        chart.setChartBoxColor(new Color(255, 255, 255, 128));
        chart.getLegendBuilder().setItemFont(new Font("Dialog", 
                Font.ITALIC, 12));
        chart.setLegendAnchor(LegendAnchor.TOP_RIGHT);
//        CategoryPlot3D plot = (CategoryPlot3D) chart.getPlot();
//        LineRenderer3D renderer = (LineRenderer3D) plot.getRenderer();
//        renderer.setLineHeight(0.05);
        ChartPanel3D chartPanel = new ChartPanel3D(chart);
        content.setChartPanel(chartPanel);
        content.add(new DisplayPanel3D(chartPanel));
        chartPanel.zoomToFit(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        return content;
    }
  
    /**
     * Creates a sample dataset (hard-coded for the purpose of keeping the
     * demo self-contained - in practice you would normally read your data
     * from a file, database or other source).
     * 
     * @return A sample dataset.
     */
    private static CategoryDataset3D createDataset() {    
        StandardCategoryDataset3D dataset = new StandardCategoryDataset3D();
        
        // http://investor.bankofamerica.com/phoenix.zhtml?c=71595&p=quarterlyearnings#fbid=Ke_-yRMOTA4
        DefaultKeyedValues s0 = new DefaultKeyedValues();
        s0.put("Q3/11", 5889);
        s0.put("Q4/11", 1584);
        s0.put("Q1/12", 328);
        s0.put("Q2/12", 2098);
        s0.put("Q3/12", -33);
        s0.put("Q4/12", 367);
        s0.put("Q1/13", 1110);
        s0.put("Q2/13", 3571);
        s0.put("Q3/13", 2218);
        dataset.addSeriesAsRow("Bank of America", s0);

        // http://www.citigroup.com/citi/investor/data/qer313s.pdf
        DefaultKeyedValues s1 = new DefaultKeyedValues();
        s1.put("Q3/11", 3771);
        s1.put("Q4/11", 956);
        s1.put("Q1/12", 2931);
        s1.put("Q2/12", 2946);
        s1.put("Q3/12", 468);
        s1.put("Q4/12", 1196);
        s1.put("Q1/13", 3808);
        s1.put("Q2/13", 4182);
        s1.put("Q3/13", 3227);
        dataset.addSeriesAsRow("Citigroup", s1);
        
        // https://www.wellsfargo.com/downloads/pdf/press/3q13pr.pdf 
        DefaultKeyedValues s3 = new DefaultKeyedValues();
        s3.put("Q3/11", 4055);
        s3.put("Q4/11", 4107);
        s3.put("Q1/12", 4248);
        s3.put("Q2/12", 4622);
        s3.put("Q3/12", 4937);
        s3.put("Q4/12", 4857);
        s3.put("Q1/13", 4931);
        s3.put("Q2/13", 5272);
        s3.put("Q3/13", 5317);

        dataset.addSeriesAsRow("Wells Fargo", s3);

        // http://files.shareholder.com/downloads/ONE/2724973994x0x696270/df38c408-0315-43dd-b896-6fe6bc895050/3Q13_Earnings_Earnings_Supplement.pdf
        DefaultKeyedValues s2 = new DefaultKeyedValues();
        s2.put("Q3/11", 4262);
        s2.put("Q4/11", 3728);
        s2.put("Q1/12", 4924);
        s2.put("Q2/12", 4960);
        s2.put("Q3/12", 5708);
        s2.put("Q4/12", 5692);
        s2.put("Q1/13", 6529);
        s2.put("Q2/13", 6496);
        s2.put("Q3/13", -380);
        dataset.addSeriesAsRow("J.P.Morgan", s2);
        
        return dataset;
    }

    /**
     * Starting point for the app.
     *
     * @param args  command line arguments (ignored).
     */
    public static void main(String[] args) {
        LineChart3DDemo2 app = new LineChart3DDemo2(
                "OrsonCharts: LineChart3DDemo2.java");
        app.pack();
        app.setVisible(true);
    }

}