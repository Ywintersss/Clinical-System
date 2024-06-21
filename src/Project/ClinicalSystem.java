package Project;

import Project.Interface.Layout;
import Project.Interface.Pages.*;


import Project.Interface.Pages.Components.*;
import Project.Records.Recorder;
import Project.Scheduler.Scheduler;
import Project.Payments.PaymentHandler;
import Project.Controller.UserDataManager;
import Project.Interface.Pages.Components.PopUpAdmin;
import Project.Interface.Pages.Components.PopUpDefault;
import Project.Interface.Pages.Components.PopUpDoctor;
import Project.Interface.Pages.Components.PopUpPatient;
import Project.Users.*;
import Project.Utilities.Utilities;
import javafx.scene.Parent;
import java.util.Stack;
import java.util.regex.Pattern;

import Project.Interface.Pages.Components.Notification;
import jdk.jshell.execution.Util;


public class ClinicalSystem {
    private static final Stack<Parent> pageStack = new Stack<>();
    private static final UserDataManager userDataManager = UserDataManager.getInstance();
    private static final PaymentHandler paymentHandler = PaymentHandler.getInstance();
    private static final Scheduler scheduler = Scheduler.getInstance();
    private static final Recorder recorder = Recorder.getInstance();
    private static Layout layout;

    public static void login(String username, String password) {
        //TODO validation
        User user = userDataManager.getUser(username, password);
        if (user != null) {
            Notification.information("Login Successful");
            if (user instanceof Patient) {
                Patient patient = (Patient) user;
                UserSession.getInstance().setCurrentUser(patient);
                navigateTo(new Home().getHome());
                layout.setHeaderPopUp(new PopUpPatient());
            } else if (user instanceof Doctor) {
                Doctor doctor = (Doctor) user;
                UserSession.getInstance().setCurrentUser(doctor);
                navigateTo(new DoctorMainPage().getDoctorMainPage());
                layout.setHeaderPopUp(new PopUpDoctor());
            } else if (user instanceof Admin) {
                Admin admin = (Admin) user;
                UserSession.getInstance().setCurrentUser(admin);
                navigateTo(new AdminMainPage().getAdminMainPage());
                layout.setHeaderPopUp(new PopUpAdmin());
            }
            Notification.information("Login Successful");
        } else {
            Notification.error("Login Failed");
        }
    }

    public static void logout() {
        layout.setContent(new Home().getHome());
        layout.setHeaderPopUp(new PopUpDefault());
        UserSession.getInstance().clearSession();
        pageStack.clear();
        pageStack.push(new Home().getHome());
    }

    public static boolean register(int flag, String ...args) {


        if (Utilities.validatePassword(args[1]) && Utilities.validateEmail(args[3]) && Utilities.validatePhoneNumber(args[4])) {
            if (flag == 1) {
                userDataManager.addPatient(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8]);
            } else if (flag == 2) {
                userDataManager.addDoctor(args[0],args[1],args[2],args[3],args[4],args[5],args[6],args[7],args[8],args[9],args[10]);
            } else if (flag == 3) {
                userDataManager.addAdmin(args[0],args[1]);
            }
            return true;
        }else{
	        if (!Utilities.validatePassword(args[1])) {
		        Notification.error("Password is in invalid format!");
	        }
            if (!Utilities.validateEmail(args[3])) {
		        Notification.error("Email is in invalid format!");
	        }
            if (!Utilities.validatePhoneNumber(args[4])) {
		        Notification.error("Phone number is in invalid format!");
	        }
	        return false;
        }

    }
    public static Layout getLayout() {
        if (layout == null) {
            layout = new Layout();
        }
        return layout;
    }

    public static UserDataManager getUserDataManager() {
        return userDataManager;
    }
    public static PaymentHandler getPaymentHandler() {
        return paymentHandler;
    }
    public static Scheduler getScheduler() {
        return scheduler;
    }
    public static Recorder getRecorder() {
        return recorder;
    }

    public static void navigateTo(Parent newPage) {
        if (!pageStack.isEmpty() && newPage.equals(pageStack.peek())) {
            return;
        }

        pageStack.push(newPage);
        System.out.println(pageStack);
        getLayout().setContent(newPage);
    }

    public static void refresh(Parent Page) {
        pageStack.pop();
        getLayout().setContent(Page);
        pageStack.push(Page);
    }

    public static void back() {
        pageStack.pop();
        System.out.println(pageStack);
        getLayout().setContent(pageStack.peek());
    }
    public static Stack<Parent> getPageStack() {
        return pageStack;
    }

    public static void main(String[] args) {

    }
}
