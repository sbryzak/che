class compose {
  file { "/opt/che/docker-compose.yml":
    ensure  => "present",
    content => template("compose/docker-compose.yml.erb"),
    mode    => '644',
  }
}
