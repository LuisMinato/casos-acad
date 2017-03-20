/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpi135;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juank
 */
@Entity
@Table(name = "paso_requisito", catalog = "casosacadtpi135", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PasoRequisito.findAll", query = "SELECT p FROM PasoRequisito p")
    , @NamedQuery(name = "PasoRequisito.findByIdPaso", query = "SELECT p FROM PasoRequisito p WHERE p.pasoRequisitoPK.idPaso = :idPaso")
    , @NamedQuery(name = "PasoRequisito.findByIdRequisito", query = "SELECT p FROM PasoRequisito p WHERE p.pasoRequisitoPK.idRequisito = :idRequisito")
    , @NamedQuery(name = "PasoRequisito.findByFinalizado", query = "SELECT p FROM PasoRequisito p WHERE p.finalizado = :finalizado")})
public class PasoRequisito implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PasoRequisitoPK pasoRequisitoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Finalizado", nullable = false)
    private boolean finalizado;
    @JoinColumn(name = "id_paso", referencedColumnName = "id_paso", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Paso paso;
    @JoinColumn(name = "id_requisito", referencedColumnName = "id_requisito", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Requisito requisito;

    public PasoRequisito() {
    }

    public PasoRequisito(PasoRequisitoPK pasoRequisitoPK) {
        this.pasoRequisitoPK = pasoRequisitoPK;
    }

    public PasoRequisito(PasoRequisitoPK pasoRequisitoPK, boolean finalizado) {
        this.pasoRequisitoPK = pasoRequisitoPK;
        this.finalizado = finalizado;
    }

    public PasoRequisito(int idPaso, int idRequisito) {
        this.pasoRequisitoPK = new PasoRequisitoPK(idPaso, idRequisito);
    }

    public PasoRequisitoPK getPasoRequisitoPK() {
        return pasoRequisitoPK;
    }

    public void setPasoRequisitoPK(PasoRequisitoPK pasoRequisitoPK) {
        this.pasoRequisitoPK = pasoRequisitoPK;
    }

    public boolean getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public Paso getPaso() {
        return paso;
    }

    public void setPaso(Paso paso) {
        this.paso = paso;
    }

    public Requisito getRequisito() {
        return requisito;
    }

    public void setRequisito(Requisito requisito) {
        this.requisito = requisito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pasoRequisitoPK != null ? pasoRequisitoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PasoRequisito)) {
            return false;
        }
        PasoRequisito other = (PasoRequisito) object;
        if ((this.pasoRequisitoPK == null && other.pasoRequisitoPK != null) || (this.pasoRequisitoPK != null && !this.pasoRequisitoPK.equals(other.pasoRequisitoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tpi135.PasoRequisito[ pasoRequisitoPK=" + pasoRequisitoPK + " ]";
    }
    
}
