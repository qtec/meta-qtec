SUMMARY = "Khronos OpenCL headers"
DESCRIPTION = "The FGLRX xorg driver contains the proprietary xorg module for ATI/AMD cards"
LICENSE = "other-MIT-style-KHRONOS"

FILES_${PN} = ""
RDEPENDS_${PN}-dev = ""

SRC_URI = " \
		http://www.khronos.org/registry/cl/api/${PV}/opencl.h;name=opencl.h \
		http://www.khronos.org/registry/cl/api/${PV}/cl_platform.h;name=cl_platform.h  \
		http://www.khronos.org/registry/cl/api/${PV}/cl.h;name=cl.h \
		http://www.khronos.org/registry/cl/api/${PV}/cl_ext.h;name=cl_ext.h \
		http://www.khronos.org/registry/cl/api/${PV}/cl_d3d10.h;name=cl_d3d10.h \
		http://www.khronos.org/registry/cl/api/${PV}/cl_gl.h;name=cl_gl.h \
		http://www.khronos.org/registry/cl/api/${PV}/cl_gl_ext.h;name=cl_gl_ext.h \
		http://www.khronos.org/registry/cl/api/${PV}/cl_dx9_media_sharing.h;name=cl_dx9_media_sharing.h \
		http://www.khronos.org/registry/cl/api/${PV}/cl_d3d11.h;name=d3d11.h \
		http://www.khronos.org/registry/cl/api/${PV}/cl.hpp;name=cl.hpp \
"
SRC_URI[opencl.h.md5sum] = "6f511443ae9d2f85146e0c35221c1e7d"
SRC_URI[opencl.h.sha256sum] = "be1bf717e103678292d6718b3608c9e54a48588c02d3d387a48656fac46ec8d9"
SRC_URI[cl_platform.h.md5sum] = "36f9f225c4cb2f1c6ff47a222807f29b"
SRC_URI[cl_platform.h.sha256sum] = "e212b89bba54f7a4e090a2b2f58f779241ffb3b45b870eee790689fc2ca0e0ae"
SRC_URI[cl.h.md5sum] = "d7ac66b1df762a8ee0f2e86478798321"
SRC_URI[cl.h.sha256sum] = "a5465c2ed1a0687878c8f7aa25f94626d7cd3a3868163ecaa6e8b36d6ed52368"
SRC_URI[cl_ext.h.md5sum] = "b802bd24542701c93577834c715cb7e9"
SRC_URI[cl_ext.h.sha256sum] = "d23a11d1daebe39c6f5a9743f356bb58cdf0bf5a2019c723a6e2dc1e7dcb0360"
SRC_URI[cl_d3d10.h.md5sum] = "1927b2de5d383fb2dee70aec67cfc6aa"
SRC_URI[cl_d3d10.h.sha256sum] = "c7adb38a19663ee240977afc64903f4638d9c5c03ca478793c9f7a15c1c6ac2b"
SRC_URI[cl_gl.h.md5sum] = "e2ee1abe980e7bc13430c01c51f29d9a"
SRC_URI[cl_gl.h.sha256sum] = "aa49d380177ac538b8ab00196381301fac6178e5b931398e3da43067ac3c33c4"
SRC_URI[cl_gl_ext.h.md5sum] = "9e389c6edecc8559ca9b861ed3e8e96b"
SRC_URI[cl_gl_ext.h.sha256sum] = "4d663bbfc932ab405623e5f5d1bba3f438351d0ead65e1ccdd9bb769caf7a7d0"
SRC_URI[cl_dx9_media_sharing.h.md5sum] = "c6ddf105cc4a01416783c4048c5d991c"
SRC_URI[cl_dx9_media_sharing.h.sha256sum] = "26fb40bac8e229747bdc27b350b836e3703c1e946cb40893f4c8ab2289203920"
SRC_URI[d3d11.h.md5sum] = "a06c084208aae905f13007502518046f"
SRC_URI[d3d11.h.sha256sum] = "8ade5d641e1acd12fa37bac36abf41f24985f4e38ceb32da9c01cc0e4fc3742f"
SRC_URI[cl.hpp.md5sum] = "06ec31d6f2d4fc15e3db2d49e2cedb8e"
SRC_URI[cl.hpp.sha256sum] = "d7c8f5c17f88e098dc9f71d80e4b7408fab353e2828b0ba4d4bb55adaa427e83"

S = "${WORKDIR}"

LIC_FILES_CHKSUM = "file://opencl.h;endline=22;md5=8701f74ce3251b607ff5bda52c90a96c"

PR = "r7"

do_install(){
	install -d -m 0755		${D}${includedir}/CL/
	install -m 0644 		${S}/*.h ${D}${includedir}/CL/
	install -m 0644 		${S}/*.hpp ${D}${includedir}/CL/
}

inherit allarch
