#
# Copyright (C) 2012-2016 Qtechnology A/S
#
inherit core-image

DESCRIPTION = "Development Image for Qtec cameras"

#Kernel
IMAGE_INSTALL += "kernel kernel-firmware"
#Qtec repo
IMAGE_INSTALL += "poky-qtec-feed-config-deb"
#System tools
IMAGE_INSTALL += "lsb util-linux-bash-completion util-linux-dmesg lsb file ldd"
IMAGE_INSTALL_append_qt5022-open += "clinfo"
#Hardware test tools
IMAGE_INSTALL += "v4l-utils pciutils usbutils"
#Qtec GWT
IMAGE_INSTALL += "qtec-camera-gwt"
#Notebook
IMAGE_INSTALL += "notebook-launcher"
#Python image processing
IMAGE_INSTALL += "python3-scipy python3-matplotlib python3-scikit-image"
#Vision Related Libraries
IMAGE_INSTALL += "opencv qv4l2 imagemagick"
#Gstreamer
IMAGE_INSTALL += "gstreamer1.0 gstreamer1.0-plugins-qtec-core-meta gstreamer1.0-plugins-base-meta gstreamer1.0-plugins-good-meta gstreamer1.0-plugins-bad-meta gstreamer1.0-plugins-ugly-meta"
#Gcc support
IMAGE_INSTALL += "binutils libgcc-dev gcc-symlinks g++-symlinks libc6-dev eglibc-staticdev make gdb"
#Profiling
IMAGE_INSTALL += "perf gst-instruments"


IMAGE_FEATURES += "package-management x11-base allow-empty-password empty-root-password splash ssh-server-dropbear"

EXTRA_IMAGEDEPENDS += "grub-efi:do_deploy"
