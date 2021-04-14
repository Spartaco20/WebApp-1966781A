/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webapp.facade;

import edu.webapp.entity.Categorias;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface CategoriasFacadeLocal {

    void create(Categorias categorias);

    void edit(Categorias categorias);

    void remove(Categorias categorias);

    Categorias find(Object id);

    List<Categorias> findAll();

    List<Categorias> findRange(int[] range);

    int count();
    
}
