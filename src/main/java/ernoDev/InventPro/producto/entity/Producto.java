package ernoDev.InventPro.producto.entity;

import ernoDev.InventPro.proveedor.entity.Proveedor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Representa un producto del catálogo de inventario.
 *
 * Es la entidad central del sistema: sobre ella se calculan las
 * alertas de stock mínimo, los reportes de productos más
 * vendidos/agotados y el inventario valorizado.
 */
@Entity
@Data
@Table(name = "productos")
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Código de negocio (SKU) del producto, distinto del id técnico.
    // Es el que el bodeguero usa para identificar el producto físicamente.
    private String codigo;

    private String nombre;
    private String descripcion;

    // BigDecimal en vez de Float: evita errores de redondeo en
    // cálculos monetarios (importante para el inventario valorizado).
    private BigDecimal precioCompra;
    private BigDecimal precioVenta;

    // Stock actual disponible. No se debe editar manualmente:
    // se recalcula automáticamente cada vez que se registra
    // una entrada o salida de inventario, desde la capa de servicio.
    private int stock;

    // Umbral mínimo de stock. Cuando "stock" llega o cae por debajo
    // de este valor, el sistema debe generar una alerta y el producto
    // aparece en el reporte de "próximos a agotarse".
    private int stockMinimo;

    // Código para el escáner de código de barras (funcionalidad extra).
    private String codigoBarras;

    // Ruta o URL de la imagen del producto.
    private String imagen;

    // true = producto activo (disponible para movimientos),
    // false = inactivo/descontinuado (se conserva su historial).
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;
}