package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Components.Notification;
import Project.Interface.Pages.Templates.TableListingView;
import Project.Records.Feedback;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

public class ViewFeedBack extends TableListingView {
    private ObservableList<Feedback> feedback;
    private Button deleteFeedBack;

    public ViewFeedBack(){
        super("Feedback List");
        feedback = ClinicalSystem.getRecorder().getAllFeedback();

        addColumn("Feedback");
        addColumn("Date");
        addColumn("Time");

        deleteFeedBack = new Button("Delete");
        deleteFeedBack.setOnAction(e -> {
            int index = getButtonIndex(e);

            Feedback feedback = (Feedback) getTableView().getItems().get(index);
            try{
                //Notification.confirmation("Are you sure?");
                ClinicalSystem.getRecorder().removeFeedback(feedback.getFeedbackID());
                ClinicalSystem.back();
                ClinicalSystem.navigateTo(new ViewFeedBack().getTable());
                Notification.information("Deleted");
            } catch (Exception exception) {
                Notification.information("Error Deleting");
            }

        });

        addColumnButtons(deleteFeedBack);

        initTableData(feedback);

        evenWidth();
    }
}
