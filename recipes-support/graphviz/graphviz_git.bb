SUMMARY = "Graphviz - Graph Visualization Software."
DESCRIPTION = "Graphviz is open source graph visualization software. Graph visualization is a way of representing structural information as diagrams of abstract graphs and networks. It has important applications in networking, bioinformatics,  software engineering, database and web design, machine learning, and in visual interfaces for other technical domains."
HOMEPAGE = "http://www.graphviz.org/"
SECTION = "graphics"
LICENSE = "EPL-1.0"
LIC_FILES_CHKSUM = "file://COPYING;beginline=1;endline=2;md5=737cf7b11c0759e6d3b0d6cb08b7c4f8"

DEPENDS += "graphviz-native bison flex libtool zlib"
DEPENDS_class-native = ""

SRC_URI = "\
	   git://github.com/ellson/graphviz.git;protocol=https\
	   file://0001-Add-version-file.patch\
	   file://mkdefs-native.patch\
	   file://fix-expat-test.patch\
	   "
SRCREV = "dde25fdd2111c5a931a5ea39cd3b4fee919c6d03"

S = "${WORKDIR}/git"

inherit autotools-brokensep pkgconfig

FILES_${PN}-dbg += "${libdir}/${PN}/java/org/${PN}/.debug"
FILES_${PN}-dbg += "${libdir}/${PN}/guile/.debug"

PACKAGECONFIG ??= "ghostscript rsvg cairo swig tcl gtk sfdp png"
PACKAGECONFIG_append = " ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'X11', '', d)}"
PACKAGECONFIG_class-native ??= ""

PACKAGECONFIG[sfdp] = "--enable-sfdp=yes, --disable-sfdp, ,"
PACKAGECONFIG[swig] = "--enable-swig=yes, --disable-swig, swig,"
PACKAGECONFIG[lua] = "--enable-lua=yes, --disable-lua, lua,"
PACKAGECONFIG[cairo] = "--with-pangocairo=yes, --with-pangocairo=no, cairo,"
PACKAGECONFIG[tcl] = "--enable-tcl=yes --with-tclsh=tclsh, --disable-tcl, tcl, tcl"
PACKAGECONFIG[glut] = "--with-glut=yes, --without-glut, mesa-glut,"
PACKAGECONFIG[gtk] = "--with-gtk=yes, --without-gtk, gtk+ libxaw libxt libxmu,"
PACKAGECONFIG[ghostscript] = "--with-ghostscript=yes, --without-ghostscript, ghostscript,"
PACKAGECONFIG[fontconfig] = "--with-fontconfig=yes, --without-fontconfig, fontconfig,"
PACKAGECONFIG[freetype] = "--with-freetype2=yes, --with-freetype2=no, freetype,"
PACKAGECONFIG[poppler] = "--with-poppler=yes, --with-poppler=no, poppler,"
PACKAGECONFIG[guile] = "--enable-guile=yes, --enable-guile=no, guile libunistring bdwgc, "
PACKAGECONFIG[php] = "--enable-php=yes, --enable-php=no, php,"
PACKAGECONFIG[perl] = "--enable-perl=yes, --enable-perl=no, perl,"
PACKAGECONFIG[python] = "--enable-python=yes, --enable-python=no, python ,"
PACKAGECONFIG[ruby] = "--with-ruby=yes, --with-ruby=no, ruby, "
PACKAGECONFIG[qt] = "--with-qt=yes, --with-qt=no, qte,"
PACKAGECONFIG[glade] = "--with-glade=yes, --with-glade=no, glade3,"
PACKAGECONFIG[libgd] = "--with-libgd=yes, --with-libgd=no, libglade,"
PACKAGECONFIG[png] = "--with-libpng=yes, --with-libpng=no, libpng,"
PACKAGECONFIG[rsvg] = "--with-rsvg=yes, --with-rsvg=no, librsvg, librsvg"
PACKAGECONFIG[pixbuf] = "--with-gdk=yes --with-gdk-pixbuf=yes, --with-gdk=no --with-gdk-pixbuf=no, gdk-pixbuf,"
PACKAGECONFIG[X11] = "--with-x, --without-x, libx11 virtual/libx11, "
PACKAGECONFIG[java] = "--enable-java=yes, --enable-java=no, openjdk-8-native,"

EXTRA_OECONF = "  --enable-ltdl -enable-java=no"

EXTRA_OECONF_class-native = " \
    --enable-sharp=no \
    --enable-java=no \
    --enable-ocaml=no \
    --enable-r=no \
    --with-devil=no \
    --with-lasi=no \
    --with-gtkgl=no \
    --with-gtkglext=no \
    --with-gts=no \
    --with-ann=no \
    --with-ortho=no \
    --with-digcola=no \
    --with-smyrna=no \
    --with-ipsepcola=no \
     "

do_configure_append () {
    # copy mkdefs from the native graphviz build
    if [ "${PN}" != "graphviz-native" ]; then
        cp ${STAGING_BINDIR_NATIVE}/graphviz-${PV}/mkdefs ${S}/lib/gvpr/mkdefs-native
    fi
}

do_compile_class-native () {
    cd lib/gvpr
    oe_runmake mkdefs
}

do_install_class-native () {
    install -d ${D}${bindir}/graphviz-${PV}
    install -m 755 lib/gvpr/mkdefs ${D}${bindir}/graphviz-${PV}/
}

INSANE_SKIP_${PN} += "dev-so"

RDEPENDS_${PN} = "libxml2 libcroco"
RDEPENDS_class-native = ""

BBCLASSEXTEND = "native"
