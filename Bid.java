import java.util.ArrayList;
import java.util.Calendar;

public class Bid {
    Seller seller; //The seller of the bid
    ArrayList <Offer> offres = new ArrayList<>();

    Double priceStart; //Starting price of the product
    //todo: See how to schedule the bid later
    Calendar calendar;
    double timer;

    public Bid(Seller seller, ArrayList<Offer> offres, Double priceStart, Calendar calendar, double timer) {
        //todo : Add scanners
        this.seller = seller;
        this.offres = offres;
        this.priceStart = priceStart;
        this.calendar = calendar;
        this.timer = timer;
    }

    public Seller getSeller() {
        return seller;
    }

    public ArrayList<Offer> getOffres() {
        return offres;
    }

    public Double getPriceStart() {
        return priceStart;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public double getTimer() {
        return timer;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public void setOffres(ArrayList<Offer> offres) {
        this.offres = offres;
    }

    public void setPriceStart(Double priceStart) {
        this.priceStart = priceStart;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public void setTimer(double timer) {
        this.timer = timer;
    }
}
