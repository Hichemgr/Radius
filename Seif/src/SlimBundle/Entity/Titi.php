<?php

namespace SlimBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Titi
 *
 * @ORM\Table(name="titi")
 * @ORM\Entity(repositoryClass="SlimBundle\Repository\TitiRepository")
 */
class Titi
{
    /**
     * @var int
     *
     * @ORM\Column(name="id", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="AUTO")
     */
    private $id;


    /**
     * Get id
     *
     * @return int
     */
    public function getId()
    {
        return $this->id;
    }
}

