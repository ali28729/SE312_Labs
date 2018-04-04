/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecafe;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ali
 */
@Entity
@Table(name = "order_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderHistory.findAll", query = "SELECT o FROM OrderHistory o")
    , @NamedQuery(name = "OrderHistory.findById", query = "SELECT o FROM OrderHistory o WHERE o.id = :id")
    , @NamedQuery(name = "OrderHistory.findByTime", query = "SELECT o FROM OrderHistory o WHERE o.time = :time")
    , @NamedQuery(name = "OrderHistory.findByDate", query = "SELECT o FROM OrderHistory o WHERE o.date = :date")
    , @NamedQuery(name = "OrderHistory.findByTotalAmount", query = "SELECT o FROM OrderHistory o WHERE o.totalAmount = :totalAmount")})
public class OrderHistory implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "total_amount")
    private int totalAmount;
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @ManyToOne(optional = false)
    private Orders orderId;
    @JoinColumn(name = "customer_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User customerId;

    public OrderHistory() {
    }

    public OrderHistory(Integer id) {
        this.id = id;
    }

    public OrderHistory(Integer id, Date time, Date date, int totalAmount) {
        this.id = id;
        this.time = time;
        this.date = date;
        this.totalAmount = totalAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        Date oldTime = this.time;
        this.time = time;
        changeSupport.firePropertyChange("time", oldTime, time);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        Date oldDate = this.date;
        this.date = date;
        changeSupport.firePropertyChange("date", oldDate, date);
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        int oldTotalAmount = this.totalAmount;
        this.totalAmount = totalAmount;
        changeSupport.firePropertyChange("totalAmount", oldTotalAmount, totalAmount);
    }

    public Orders getOrderId() {
        return orderId;
    }

    public void setOrderId(Orders orderId) {
        Orders oldOrderId = this.orderId;
        this.orderId = orderId;
        changeSupport.firePropertyChange("orderId", oldOrderId, orderId);
    }

    public User getCustomerId() {
        return customerId;
    }

    public void setCustomerId(User customerId) {
        User oldCustomerId = this.customerId;
        this.customerId = customerId;
        changeSupport.firePropertyChange("customerId", oldCustomerId, customerId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderHistory)) {
            return false;
        }
        OrderHistory other = (OrderHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ecafe.OrderHistory[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
