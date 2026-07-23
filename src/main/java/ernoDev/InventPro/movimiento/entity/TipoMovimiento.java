package ernoDev.InventPro.movimiento.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Tipo de movimiento de inventario.
 *
 * Valores esperados: "ENTRADA" (incrementa el stock, ej: compra a
 * proveedor) y "SALIDA" (disminuye el stock, ej: venta).
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tipos_movimiento")
public class TipoMovimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
}
