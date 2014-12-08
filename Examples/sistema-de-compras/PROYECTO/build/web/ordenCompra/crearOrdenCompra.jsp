<%-- 
    Document   : crearOrdenCompra
    Created on : Nov 15, 2014, 8:57:47 PM
    Author     : johnmachahuay
--%>

<%@page import="compraProveedores.beans.usuarioBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<usuarioBean> proveedores = (ArrayList<usuarioBean>)request.getAttribute("proveedores");
%>
<!DOCTYPE html>
<html>
    <head>
        <link href="<%=request.getContextPath()%>/css/master.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="<%=request.getContextPath()%>/SrvPedido">Regresar</a>
        <form>
        <!--empezar aqui -->  
         <table>
          <tbody>
              <tr>
                <td class="tituloFormulario"><div align="center">ORDEN DE COMPRA </div></td>
              </tr>
          <!--Inicio del border Layout -->  
            <tr>
                <td>
                    <fieldset>
                        <legend>Datos Relevantes </legend>
                        <table>
                            <tbody>
                                <tr>
                                    <td class="tituloCampo">Nª orden de compra </td>
                                    <td><input name="textFieldLineaTematica" type="text" autofocus="true" class="input_text_combo" id="textFieldLineaTematica" size="60"></td>
                                </tr>
                                <tr>
                                    <td class="tituloCampo">Proveedor </td>
                                    <td class="radioCheck">
                                      <label>
                                      <select name="proveedor" class="input_text_combo" id="select">
                                            <option selected="">---Seleccione---</option>
                                            <%
                                                if(proveedores != null) {
                                                    for(usuarioBean   obj:proveedores){
                                            %>
                                            <option value="<%= obj.getId_usuario() %>">
                                                <%= obj.getNombre() %>
                                            </option>
                                            <%      }
                                                }
                                            %>
                                        </select>
                                      </label>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tituloCampo"><p>Condiciones de pago<br></p></td>
                                    <td>
                                        <input type="radio" id="Lopez" name="Integrantes" value="1">
                                        <label for="credito">credito</label>
                                        <input type="radio" id="Paico" name="Integrantes" value="2">
                                        <label for="contado">contado</label>
                                    </td>
                                </tr>
                                <tr>
                                  <td class="tituloCampo">Direccion de entrega<br> </td>
                                  <td class="radioCheck"><label>
                                    <input name="textFieldIndicador22" type="text" class="input_text_combo" id="textFieldIndicador22" size="20">
                                    </label>
                                  </td>
                                </tr>

                                <tr>
                                    <td class="tituloCampo">ingrese numero de cotizacion<br></td>
                                    <td class="tituloCampo">
                                        <label>
                                        <input name="textFieldIndicador22" type="text" class="input_text_combo" id="textFieldIndicador22" size="20">
                                        </label>
                                    </td>
                                </tr>
                                <tr>
                                    <td><center><input onclick="ingresar()" name="botonLogin" type="button" class="button" value="Ingresar"></center></td>
                                    <td><center> <input name="botonLimpiar" type="reset" class="button" value="Limpiar"></center></td>
                                </tr>
                            </tbody>
                        </table>
                    </fieldset>
                </td>
            </tr>
          </tbody>
         </table>
        </form>
    </body>
</html>
