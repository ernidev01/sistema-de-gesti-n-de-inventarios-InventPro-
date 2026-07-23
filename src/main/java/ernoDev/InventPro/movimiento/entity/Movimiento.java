package ernoDev.InventPro.movimiento.entity;

import ernoDev.InventPro.auth.entity.Usuario;
import ernoDev.InventPro.producto.entity.Producto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Registra cada entrada o salida de inventario.
 *
 * Es la tabla clave para el historial de movimientos y para los
 * reportes de entradas/salidas por fecha. El stock del producto
 * asociado se actualiza automáticamente desde la capa de servicio
 * cada vez que se guarda un registro de este tipo; nunca se edita
 * el stock directamente en Producto.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movimientos")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cantidad;

    // Texto libre: funciona como "observaciones" en una entrada
    // o como "motivo" en una salida, según tipoMovimiento.
    private String observacion;

    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    // Un usuario puede generar muchos movimientos, por eso es
    // @ManyToOne (no @OneToMany, que es para colecciones y no
    // aplica sobre un solo Usuario).
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "tipo_movimiento_id")
    private TipoMovimiento tipoMovimiento;
}