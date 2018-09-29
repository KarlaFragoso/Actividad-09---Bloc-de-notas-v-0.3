/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Views.ViewBloc;
import Models.ModelBloc;
import Controllers.ControllerBloc;

public class Main {

    
    public static void main(String[] args) {
        ViewBloc viewbloc = new ViewBloc();
        ModelBloc modelbloc = new ModelBloc();
        ControllerBloc controllerbloc = new ControllerBloc(viewbloc, modelbloc);
    }
    
}
