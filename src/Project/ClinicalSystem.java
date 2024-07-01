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

import Project.Interface.Pages.Components.Notification;


public class ClinicalSystem {
    //Keeps track of the pages visited
    private static final Stack<Parent> pageStack = new Stack<>();
    //Singleton Controller classes for user, payment, scheduler and recorder
    private static final UserDataManager userDataManager = UserDataManager.getInstance();
    private static final PaymentHandler paymentHandler = PaymentHandler.getInstance();
    private static final Scheduler scheduler = Scheduler.getInstance();
    private static final Recorder recorder = Recorder.getInstance();
    private static Layout layout;

    public static void login(String username, String password) {
        //Check if user exists
        User user = userDataManager.getUser(username, password);
        if (user != null) {
            Notification.information("Login Successful");
            //Checks type of user and sets user session
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

    //Logout
    public static void logout() {
        layout.setContent(new Home().getHome());
        layout.setHeaderPopUp(new PopUpDefault());
        UserSession.getInstance().clearSession();
        pageStack.clear();
        pageStack.push(new Home().getHome());
    }

    //Register
    public static boolean register(int flag, String ...args) {
        //validation for patient and doctor registration
        if (!(args.length < 3)) {
            if (!Utilities.validatePassword(args[1])) {
                System.out.println(args[1]);
                Notification.error("Password is in invalid format!");
                return false;
            }
            if (!Utilities.validateEmail(args[3])) {
                System.out.println(args[3]);
                Notification.error("Email is in invalid format!");
                return false;
            }
            if (!Utilities.validatePhoneNumber(args[4])) {
                System.out.println(args[4]);
                Notification.error("Phone number is in invalid format!");
                return false;
            }
        }

        //flag = 1 = Admin register patient
        //flag = 2 = addDoctor
        //flag = 3 = addAdmin
        //flag = 4 = Back to wherever to Patient came from
        if (flag == 1 || flag == 4) {
            userDataManager.addPatient(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8]);
        } else if (flag == 2) {
            userDataManager.addDoctor(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10]);
        } else if (flag == 3) {
            userDataManager.addAdmin(args[0], args[1]);
        }

        return true;
    }

    //Singleton layout of the entire page
    public static Layout getLayout() {
        if (layout == null) {
            layout = new Layout();
        }
        return layout;
    }

    //Singleton getter interface for Controller classes
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


    //Navigation
    public static void navigateTo(Parent newPage) {
        if (!pageStack.isEmpty() && newPage.equals(pageStack.peek())) {
            return;
        }

        pageStack.push(newPage);
        System.out.println(pageStack);
        getLayout().setContent(newPage);
    }

    //Refresh a page
    public static void refresh(Parent Page) {
        pageStack.pop();
        getLayout().setContent(Page);
        pageStack.push(Page);
    }

    //Back
    public static void back() {
        pageStack.pop();
        System.out.println(pageStack);
        getLayout().setContent(pageStack.peek());
    }

    //Get page stack
    public static Stack<Parent> getPageStack() {
        return pageStack;
    }
}
