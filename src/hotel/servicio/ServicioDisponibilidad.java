package hotel.servicio;

import hotel.modelo.Habitacion;
import hotel.modelo.Reserva;
import hotel.repositorio.RepositorioHabitacion;
import hotel.repositorio.RepositorioReserva;

import java.time.LocalDate;
import java.util.List;


public class ServicioDisponibilidad {



    /**
     * Servicio de aplicación responsable de verificar la disponibilidad de una habitación
     * en un rango de fechas determinado. Aplica reglas de negocio relacionadas con conflictos
     * de reservas, manteniendo la lógica fuera de las entidades y de la capa de consola.
     *
     * <p><b>Diseño (SOLID)</b>:
     * <ul>
     *   <li>SRP: Esta clase sólo verifica disponibilidad.</li>
     *   <li>DIP: Depende de interfaces de repositorio para acceder a datos.</li>
     * </ul>
     *
     * <p><b>Convención de fechas en disponibilidad</b>:
     * Se asume semántica típica de hotel: el rango se interpreta como [entrada, salida),
     * es decir, la <i>fecha de salida es excluyente</i>. Por lo tanto, una reserva que
     * termina el mismo día que inicia otra <b>no</b> se considera conflicto.
     *
     * <p><b>Dependencias esperadas</b> (en las interfaces del repositorio):
     * <ul>
     *   <li>{@code RepositorioHabitacion#obtenerPorNumero(int numero)}</li>
     *   <li>{@code RepositorioReserva#obtenerReservasPorHabitacion(int numeroHabitacion)}</li>
     * </ul>
     * Estas firmas se mencionan a modo de contrato esperado para integración.
     */
    public class ServicioDisponibilidad {

        private final RepositorioHabitacion repositorioHabitacion;
        private final RepositorioReserva repositorioReserva;

        /**
         * Crea el servicio de disponibilidad con las dependencias requeridas.
         * @param repositorioHabitacion acceso a habitaciones (para validar existencia)
         * @param repositorioReserva acceso a reservas (para verificar traslapes)
         */
        public ServicioDisponibilidad(RepositorioHabitacion repositorioHabitacion,
                                      RepositorioReserva repositorioReserva) {
            if (repositorioHabitacion == null || repositorioReserva == null) {
                throw new IllegalArgumentException("Las dependencias del servicio no pueden ser nulas.");
            }
            this.repositorioHabitacion = repositorioHabitacion;
            this.repositorioReserva = repositorioReserva;
        }

        /**
         * Verifica si una habitación está disponible en el rango de fechas indicado.
         *
         * @param numeroHabitacion número de la habitación a evaluar
         * @param fechaEntrada     fecha de entrada (inclusive)
         * @param fechaSalida      fecha de salida (exclusiva)
         * @return {@code true} si no hay reservas en conflicto; {@code false} en caso contrario
         * @throws IllegalArgumentException si las fechas son inválidas o la habitación no existe
         */
        public boolean estaDisponible(int numeroHabitacion,
                                      LocalDate fechaEntrada,
                                      LocalDate fechaSalida) {
            validarRangoFechas(fechaEntrada, fechaSalida);

            // Validar que la habitación exista desde el inicio del sistema
            Habitacion habitacion = repositorioHabitacion.obtenerPorNumero(numeroHabitacion);
            if (habitacion == null) {
                throw new IllegalArgumentException("La habitación " + numeroHabitacion + " no existe.");
            }

            // Obtener reservas existentes de esa habitación y verificar traslape
            List<Reserva> reservas = repositorioReserva.obtenerReservasPorHabitacion(numeroHabitacion);
            for (Reserva r : reservas) {
                if (r == null) continue;
                LocalDate e = r.getFechaEntrada();
                LocalDate s = r.getFechaSalida();

                // Si por alguna razón hay datos incompletos, se ignoran de la verificación
                if (e == null || s == null) continue;

                if (hayTraslape(e, s, fechaEntrada, fechaSalida)) {
                    return false; // Existe conflicto de reservas
                }
            }

            return true; // No se encontraron conflictos
        }

        /**
         * Valida que el rango de fechas sea coherente:
         * - Las fechas no pueden ser nulas.
         * - La fecha de salida debe ser posterior a la de entrada.
         */
        private void validarRangoFechas(LocalDate entrada, LocalDate salida) {
            if (entrada == null || salida == null) {
                throw new IllegalArgumentException("Las fechas de entrada y salida no pueden ser nulas.");
            }
            if (!salida.isAfter(entrada)) {
                throw new IllegalArgumentException("La fecha de salida debe ser posterior a la fecha de entrada.");
            }
        }

        /**
         * Determina si dos rangos [e1, s1) y [e2, s2) traslapan.
         * Con salida excluyente, <b>no hay traslape</b> si s1 <= e2 o s2 <= e1.
         */
        private boolean hayTraslape(LocalDate e1, LocalDate s1, LocalDate e2, LocalDate s2) {
            return !( !s1.isAfter(e2) || !s2.isAfter(e1) );
        }
    }
}
