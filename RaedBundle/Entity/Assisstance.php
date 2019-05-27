<?php

namespace SlimBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Assisstance
 *
 * @ORM\Table(name="assisstance")
 * @ORM\Entity
 */
class Assisstance
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id_assisstance", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idAssisstance;

    /**
     * @var string
     *
     * @ORM\Column(name="id_client", type="string", length=20, nullable=false)
     */
    private $idClient;

    /**
     * @var string
     *
     * @ORM\Column(name="id_assisstant", type="string", length=20, nullable=false)
     */
    private $idAssisstant;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="dateAss", type="date", nullable=false)
     */
    private $dateass;

    /**
     * @var string
     *
     * @ORM\Column(name="type", type="string", length=10, nullable=false)
     */
    private $type;

    /**
     * @return int
     */
    public function getIdAssisstance()
    {
        return $this->idAssisstance;
    }

    /**
     * @param int $idAssisstance
     */
    public function setIdAssisstance($idAssisstance)
    {
        $this->idAssisstance = $idAssisstance;
    }

    /**
     * @return string
     */
    public function getIdClient()
    {
        return $this->idClient;
    }

    /**
     * @param string $idClient
     */
    public function setIdClient($idClient)
    {
        $this->idClient = $idClient;
    }

    /**
     * @return string
     */
    public function getIdAssisstant()
    {
        return $this->idAssisstant;
    }

    /**
     * @param string $idAssisstant
     */
    public function setIdAssisstant($idAssisstant)
    {
        $this->idAssisstant = $idAssisstant;
    }

    /**
     * @return \DateTime
     */
    public function getDateass()
    {
        return $this->dateass;
    }

    /**
     * @param \DateTime $dateass
     */
    public function setDateass($dateass)
    {
        $this->dateass = $dateass;
    }

    /**
     * @return string
     */
    public function getType()
    {
        return $this->type;
    }

    /**
     * @param string $type
     */
    public function setType($type)
    {
        $this->type = $type;
    }


}

