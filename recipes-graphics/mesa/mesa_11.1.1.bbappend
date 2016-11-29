PROVIDES = "virtual/mesa"

RREPLACES_libgl-mesa_remove := "libgl libgl1"
RPROVIDES_libgl-mesa_remove := "libgl libgl1"
RCONFLICTS_libgl-mesa_remove := "libgl libgl1"

do_install_append(){

	rm -f ${D}${libdir}/libGL.so* ${D}${libdir}/libEGL.so* ${D}${libdir}/libGLESv2.so*

}
