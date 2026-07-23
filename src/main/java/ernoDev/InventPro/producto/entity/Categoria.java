package ernoDev.InventPro.producto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa una categoría de productos dentro del inventario.
 *
 * Ejemplos: Portátiles, Monitores, Mouse, Teclados, Impresoras.
 * Se usa para clasificar productos y facilitar los filtros de
 * consulta de inventario y los reportes.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // true = categoría activa (disponible para asignar a productos),
    // false = inactiva (se conserva por historial, pero no se debería
    // ofrecer para nuevos productos).
    private Boolean estado;

    private String descripcion;
}