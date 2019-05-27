/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

/**
 *
 * @author pc hp
 */
public class impression {
    public void print(WritableImage writableImage, Stage primaryStage) {
            ImageView imageView =new ImageView(writableImage);
            Printer printer = Printer.getDefaultPrinter();
            PageLayout pageLayout = printer.createPageLayout(Paper.A4, PageOrientation.LANDSCAPE, Printer.MarginType.DEFAULT);
            double scaleX = pageLayout.getPrintableWidth() / imageView.getBoundsInParent().getWidth();
            double scaleY = pageLayout.getPrintableHeight() / imageView.getBoundsInParent().getHeight();
            imageView.getTransforms().add(new Scale(scaleX, scaleY));

            PrinterJob job = PrinterJob.createPrinterJob();
            if (job != null) {
                boolean successPrintDialog = job.showPrintDialog(primaryStage.getOwner());
                if(successPrintDialog){
                    boolean success = job.printPage(pageLayout,imageView);
                    if (success) {
                        job.endJob();
                    }
                }
            }
        }
    
}
