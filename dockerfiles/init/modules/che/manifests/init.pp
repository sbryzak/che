class che {

# creating che.env
  file { "/opt/che/config/che.env":
    ensure  => "present",
    content => template("che/che.env.erb"),
    mode    => "644",
  }

# creating che.properties
  file { "/opt/che/config/che.properties":
    ensure  => "present",
    content => template("che/che.properties.erb"),
    mode    => "644",
    require => File[$config_dirs],
  }
}
