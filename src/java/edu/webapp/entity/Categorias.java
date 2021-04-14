/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webapp.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "categorias")
@NamedQueries({
    @NamedQuery(name = "Categorias.findAll", query = "SELECT c FROM Categorias c")})
public class Categorias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcategorias")
    private Integer idcategorias;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "icono")
    private String icono;
    @Size(max = 45)
    @Column(name = "color")
    private String color;
    @OneToMany(mappedBy = "fkCategoria", fetch = FetchType.EAGER)
    private Collection<Productos> productosCollection;

    public Categorias() {
    }

    public Categorias(Integer idcategorias) {
        this.idcategorias = idcategorias;
    }

    public Integer getIdcategorias() {
        return idcategorias;
    }

    public void setIdcategorias(Integer idcategorias) {
        this.idcategorias = idcategorias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Collection<Productos> getProductosCollection() {
        return productosCollection;
    }

    public void setProductosCollection(Collection<Productos> productosCollection) {
        this.productosCollection = productosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcategorias != null ? idcategorias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorias)) {
            return false;
        }
        Categorias other = (Categorias) object;
        if ((this.idcategorias == null && other.idcategorias != null) || (this.idcategorias != null && !this.idcategorias.equals(other.idcategorias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.webapp.entity.Categorias[ idcategorias=" + idcategorias + " ]";
    }
    
}
