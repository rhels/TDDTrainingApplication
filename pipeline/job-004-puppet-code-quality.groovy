job {
    name 'Puppet code quality'
    customWorkspace '${JENKINS_HOME}/workspace/puppet-code-quality'
    label 'docker'
    steps {
        copyArtifacts 'First build job (compilation)', 'puppet/**'
        shell('docker run --rm -v /home/jenkins-slave/workspace/puppet-code-quality/puppet:/puppet -t puppet-test')
    }
}