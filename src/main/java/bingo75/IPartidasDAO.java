/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo75;

import java.util.List;

/**
 *
 * @author jcarlosvico@maralboran.es
 */
public interface IPartidasDAO {
     
    boolean insertPartida(Bingo partida);
    
    int insertPartida(List<Bingo> lista);
    
    boolean deletePartida(Bingo partida);
    
    boolean updatePartida(String pk, Bingo bingo);
    
    List<Bingo> getAll();
    
    Bingo findByPk(String id);
    
}
