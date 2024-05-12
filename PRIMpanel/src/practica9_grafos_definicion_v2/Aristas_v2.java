/* UNIVERSIDAD DE PAMPLONA
    Ingeniería de Sistemas - Matemáticas discretas: Grafos
    M.Sc. Luis Armando Portilla Granados
    Actualizado octubre de 2022: ArrayList
*/

package practica9_grafos_definicion_v2;

//import java.awt.BasicStroke; // 2d para el grosor de la línea
//import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author Mariana
 */
public class Aristas_v2 {
    private Nodos_v2 n1, n2;
    private String nombreA;
    private int peso;
    int d = 20;  // diámetro para el óvalo
    public Aristas_v2(Nodos_v2 n1, Nodos_v2 n2, int x) {
        this.n1 = n1;
        this.n2 = n2;
        this.nombreA = n1.getNombreN() + n2.getNombreN();
        this.peso = x;       
    }

    public void pintarArista (Graphics g){ //(Graphics2D g)
        Graphics2D graphics = (Graphics2D) g;
        // http://swing-facil.blogspot.com/2011/12/renderinghints-renderizados-y.html
//        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY); //REBDERIZADO
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //SUAVISADO
//        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR); //INTERPOLACIÓN
        
        graphics.setColor(Color.GRAY);
        
        graphics.setStroke(new BasicStroke(2)); // Graphics2D grosor de línea
        graphics.drawLine(this.getN1().getX(), this.getN1().getY(), this.getN2().getX(), this.getN2().getY());
        graphics.setColor(Color.BLACK);
        if(this.getN1().getX()>this.getN2().getX() && this.getN1().getY()>this.getN2().getY()){
        graphics.drawString(String.valueOf(peso), this.getN1().getX() - Math.abs((this.getN1().getX()-this.getN2().getX())/2) ,this.getN1().getY() - Math.abs((this.getN1().getY()-this.getN2().getY())/2));
        }
        if(this.getN1().getX()<this.getN2().getX() && this.getN1().getY()<this.getN2().getY()){
        graphics.drawString(String.valueOf(peso), this.getN2().getX() - Math.abs((this.getN1().getX()-this.getN2().getX())/2),this.getN2().getY() - Math.abs((this.getN1().getY()-this.getN2().getY())/2));
        }
        if(this.getN1().getX()>this.getN2().getX() && this.getN1().getY()<this.getN2().getY()){
        graphics.drawString(String.valueOf(peso), this.getN1().getX() - Math.abs((this.getN1().getX()-this.getN2().getX())/2) ,this.getN2().getY() - Math.abs((this.getN1().getY()-this.getN2().getY())/2));
        }
        if(this.getN1().getX()<this.getN2().getX() && this.getN1().getY()>this.getN2().getY()){
        graphics.drawString(String.valueOf(peso), this.getN2().getX() - Math.abs((this.getN1().getX()-this.getN2().getX())/2) ,this.getN1().getY() - Math.abs((this.getN1().getY()-this.getN2().getY())/2));
        }
        }
        public void repintarArista (Graphics g){ //(Graphics2D g)
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setStroke(new BasicStroke(2));
        graphics.setColor(Color.RED);
        //g.setStroke(new BasicStroke(2)); // Graphics2D grosor de línea
        graphics.drawLine(this.getN1().getX(), this.getN1().getY(), this.getN2().getX(), this.getN2().getY());        
    }
        //Se creó este metodo que recibe dos nodos y se dibujan en el panel
        public void pintarNodosArista (Nodos_v2 h, Nodos_v2 n, Graphics g){
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // alta definición
//        graphics.setColor(Color.PINK); // asigna colores de la paleta básica
        Color COLOR_NODO = new Color(0, 196, 255);
        graphics.setColor(COLOR_NODO); // asigna colores personalizados
        graphics.fillOval(h.getX() - d/2, h.getY() - d/2, d, d); // relleno del círculo
        graphics.fillOval(n.getX() - d/2, n.getY() - d/2, d, d); // relleno del círculo
        graphics.setColor(Color.DARK_GRAY);
        graphics.drawString(h.getNombreN(), h.getX() - d/2, h.getY() - d/2); // *** nombre del vértice
        graphics.drawString(n.getNombreN(), n.getX() - d/2, n.getY() - d/2); // *** nombre del vértice
        }
    
    /**
     * @return the n1
     */
    public Nodos_v2 getN1() {
        return n1;
    }
    /**
     * @return the n2
     */
    public Nodos_v2 getN2() {
        return n2;
    }
    /**
     * @return the nombreA
     */
    public String getNombreA() {
        return nombreA;
    }
    
    public int getPeso(){
        return peso;
    }
}
