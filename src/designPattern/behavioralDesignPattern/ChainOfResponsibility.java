package designPattern.behavioralDesignPattern;

/* a request pass through chain of handlers where ,
 *  -> each handler does some work and 
 *  ->if it cannot handle then it passed the request to next handler
 */

/* 
 * TeamLead can only approve leave <=2 days
 * Manager  can only approve leave <=5 days
 *  Manager  can only approve leave >5 days
 */

abstract class LeaveHandler {
    protected LeaveHandler nextHandler;

    public void setNextHandler(LeaveHandler leaveHandler) {
        this.nextHandler = leaveHandler;
    }

    public abstract void leaveApprove(int days);
}

class TeamLead extends LeaveHandler {

    @Override
    public void leaveApprove(int days) {
        if (days <= 2) {
            System.out.println(days + " days Leave approved by Team Lead");
        } else if (nextHandler != null) {
            nextHandler.leaveApprove(days);
        }
    }
}

class Manager extends LeaveHandler {

    @Override
    public void leaveApprove(int days) {
        if (days <= 4) {
            System.out.println(days + " days Leave approved by Manager");
        } else if (nextHandler != null) {
            nextHandler.leaveApprove(days);
        }
    }
}

class Director extends LeaveHandler {

    @Override
    public void leaveApprove(int days) {
        System.out.println(days + " days Leave approved by Director ");
    }
}

public class ChainOfResponsibility {
    public static void main(String[] args) {
        LeaveHandler teamLead = new TeamLead();
        LeaveHandler manager = new Manager();
        LeaveHandler director = new Director();

        teamLead.setNextHandler(manager);
        manager.setNextHandler(director);

        teamLead.leaveApprove(2); // request 1
        teamLead.leaveApprove(4); // request 2
        teamLead.leaveApprove(10); // request 3

    }
}
