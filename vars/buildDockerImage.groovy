def call(String host_arg=null, String version_arg=null, String image_tag, String file_path) {
    def scriptcontents = libraryResource "Dockerfile"
    writeFile file:"Dockerfile", text: scriptcontents

    sh """
        docker build --build-arg Host=${host_arg} --build-arg Version=${params.version_arg} -t image_tag -f ${file_path} .
    """
}
