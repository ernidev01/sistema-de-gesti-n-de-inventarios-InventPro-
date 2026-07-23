package ernoDev.InventPro.auditoria.entity;

import ernoDev.InventPro.auth.entity.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Registra un cambio realizado sobre alguna tabla del sistema
 * (creación, edición o eliminación), para tener trazabilidad de
 * quién hizo qué y cuándo.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "auditoria")
public class Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Un usuario puede generar muchos registros de auditoría,
    // por eso la relación es @ManyToOne (no @OneToMany, que es
    // para colecciones y no aplica sobre un solo Usuario).
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // Nombre de la tabla/entidad afectada (ej: "productos", "usuarios").
    private String tabla;

    // Tipo de acción realizada (ej: "CREAR", "EDITAR", "ELIMINAR").
    private String accion;

    // Detalle legible de qué cambió (ej: valores anteriores/nuevos).
    private String descripcion;

    private LocalDateTime fecha;
}